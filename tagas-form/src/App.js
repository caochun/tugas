import React, {useState, Fragment, useEffect} from 'react'
import {AdvancedForm} from './AdvancedForm'
import UserTable from './UserTable'

const App = () => {

  const handleAddSubmit = async (values, {setSubmitting}) => {
    setSubmitting(true)
    await addUser(values)
    setSubmitting(false)
  }

  const handleEditSubmit = async (values, {setSubmitting}) => {
    setSubmitting(true)
    await updateUser(values.id, values)
    setSubmitting(false)
  }


  const formSchema = [
    {name: 'id', label: 'ID', componentType: 'text', required: true},
    {name: 'name', label: 'Name', componentType: 'text', required: true},
    {name: 'username', label: 'Username', componentType: 'text', required: true}
  ]


  const initialFormState = {id: 0, name: '', username: ''}

  // Setting state
  const [users, setUsers] = useState([])
  const [loading, setLoading] = useState(false)
  const [currentUser, setCurrentUser] = useState(initialFormState)
  const [editing, setEditing] = useState(false)

  // Initialize data
  useEffect(() => {
    getUsers()
  }, [])

  // CRUD operations
  const addUser = user => {

    fetch("http://localhost:8000/users", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(user)
    }).then(result => {
          setCurrentUser(initialFormState)
          getUsers()
        }
    ).catch(console.log);

  }

  const getUsers = () => {
    setLoading(true)
    fetch("http://localhost:8000/users")
        .then(res => res.json())
        .then(result => {
              setUsers(result)
              setLoading(false)
            }
        )
        .catch(console.log);
  }


  const deleteUser = id => {
    setEditing(false)

    fetch("http://localhost:8000/users/" + id, {
      method: "DELETE"
    })
        .then(res => res.json())
        .then(result => {
          setCurrentUser(initialFormState);
          getUsers();
        });
  }

  const updateUser = (id, updatedUser) => {
    setEditing(false)

    fetch("http://localhost:8000/users/" + id, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(updatedUser)
    })
        .then(res => res.json())
        .then(result => {
          setEditing(false)
          getUsers()
        });

  }

  const editRow = user => {
    setEditing(true)

    setCurrentUser({id: user.id, name: user.name, username: user.username})
  }

  return (
      <div className="container">
        <h1>CRUD App</h1>
        <div className="flex-row">
          <div className="flex-large">

            {editing ? (
                <Fragment>
                  <h2>Edit user</h2>

                  <AdvancedForm schema={formSchema} onSubmit={handleEditSubmit} initialValues={currentUser}
                                buttonLabel="Update"/>

                </Fragment>
            ) : (
                <Fragment>
                  <h2>Add user</h2>
                  <AdvancedForm schema={formSchema} onSubmit={handleAddSubmit}
                                initialValues={initialFormState}
                                buttonLabel="Add"/>
                </Fragment>
            )}
          </div>
          <div className="flex-large">
            <h2>View users</h2>
            <UserTable users={users} editRow={editRow} deleteUser={deleteUser}/>
          </div>
        </div>
      </div>
  )
}

export default App
